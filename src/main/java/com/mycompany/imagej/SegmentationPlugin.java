package com.mycompany.imagej;

import java.io.IOException;

import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.algorithm.labeling.ConnectedComponents;
import net.imglib2.img.Img;
import net.imglib2.roi.labeling.ImgLabeling;
import net.imglib2.type.numeric.RealType;

@Plugin(type = Command.class, menuPath = "Plugins>MySegmentation")
public class SegmentationPlugin implements Command {

	@Parameter
	private ImageJ ij;
	
	@Parameter
	private Img img;
	
	// main function
	// type "main", then ctrl+space, select blue
	// not executed as a plugin
	public static void main(String[] args) throws IOException {
		
		// launch new instance of ImageJ
		// type "ImageJ", ctrl+space, select ImageJ2
		final ImageJ ij = new ImageJ();
		
		// call GUI
		ij.ui().showUI();
		
		// open image
		String filepath = "/Users/Keisuke/learnathon/handson/Cell_Colony.tif";
		Dataset dataset = (Dataset) ij.io().open(filepath);
		Img img = dataset.getImgPlus().getImg();
		ij.command().run(SegmentationPlugin.class, true, "img", img);
	}
	
	private void countdots(Img img, ImageJ ij) {

		// show image
//		ij.ui().show(img);
	
		// apply Gaussian blur (from imglib2)
		RandomAccessibleInterval blurred = ij.op().filter().gauss(img, 2);
		
		// thresholding
		IterableInterval blurred2 = ij.convert().convert(blurred, IterableInterval.class);
		IterableInterval threshold = ij.op().threshold().otsu(blurred2);
		ij.ui().show(threshold);
		
		Img threshold2 = ij.op().create().img(threshold);
		IterableInterval inverted = ij.op().image().invert(threshold2, threshold);
		ij.ui().show(inverted); // so colonies have values 255

		// segmentation with connected component analysis
		ImgLabeling labels = ij.op().labeling().cca((RandomAccessibleInterval) inverted, ConnectedComponents.StructuringElement.FOUR_CONNECTED);
		ij.ui().show(labels.getIndexImg());
		
		RealType nColonies = ij.op().stats().max((Iterable) labels.getIndexImg());
		System.out.println(nColonies);
		
	}

	@Override
	public void run() {
		countdots(img, ij);
	}
	
}

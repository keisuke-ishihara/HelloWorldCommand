package com.mycompany.imagej;

import java.io.IOException;

import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;

public class SegmentationPlugin {

	// main function
	// type "main", then ctrl+space, select blue
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
		
		// show image
		ij.ui().show(img);
	
		// apply Gausian blur (from imglib2)
		RandomAccessibleInterval blurred = ij.op().filter().gauss(img, 10);
		ij.ui().show(blurred);
		
		// thresholding
		
		// segmentation
		
	}
	
}

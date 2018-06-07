/*
 * To the extent possible under law, the ImageJ developers have waived
 * all copyright and related or neighboring rights to this tutorial code.
 *
 * See the CC0 1.0 Universal license for details:
 *     http://creativecommons.org/publicdomain/zero/1.0/
 */

package com.mycompany.imagej;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scijava.Context;
import org.scijava.app.App;
import org.scijava.app.AppService;
import org.scijava.command.Command;
import org.scijava.io.IOService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginInfo;
import org.scijava.plugin.SciJavaPlugin;
import org.scijava.ui.UIService;

import clojure.java.io__init;
import net.imagej.Dataset;
import net.imagej.ImageJ;
import net.imagej.ops.OpService;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.RealType;
import net.imglib2.type.numeric.complex.ComplexFloatType;

/**
 * This example illustrates how to create an ImageJ {@link Command} plugin.
 * You should replace the parameter fields with your own inputs and outputs,
 * and replace the {@link run} method implementation with your own logic.
 * </p>
 */
@Plugin(type = Command.class, menuPath = "Plugins>Hello World")
public class HelloWorldCommand<T extends RealType<T>> implements Command {

	@Parameter
	private OpService ops;
	
	@Parameter
	private Context context;
	private IOService io;
	
    @Override
    public void run() {

    	System.out.println(context);
//    	System.out.println("Hello World");   // prints to console
//        uiService.showDialog("Hello World"); // opens dialog and shows message
    }

    /**
     * This main function serves for development purposes.
     * It allows you to run the plugin immediately out of
     * your integrated development environment (IDE).
     *
     * @param args whatever, it's ignored
     * @throws Exception
     */
    public static void main(final String... args) throws Exception {

    	// create the ImageJ application context with all available services
        final ImageJ ij = new ImageJ(); // GATEWAY into SciJava context
        
        // invoke the plugin
        ij.command().run(HelloWorldCommand.class, true);

        
        // what are the available app services?
//        AppService myApp = ij.app();
        
//        ij.op().getClass()
//        ij.op().filter().addNoise(in, rangeMin, rangeMax, rangeStdDev)
//        Map<String, App> apps = myApp.getApps();
//        App app = apps.get("ImageJ");
//        String imageJGroupId = apps.get("ImageJ").getGroupId();
//        System.out.println(imageJGroupId);

//        PluginInfo<SciJavaPlugin> myPlugin = ij.plugin().getPlugin(HelloWorldCommand.class);
//        System.out.println(myPlugin);

//        ij.ui().showUI();
//        ij.ui().show(imageJGroupId);
//        System.out.println(apps);
                
    }

}

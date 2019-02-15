# Vaadin osgi demo #

This is a demo project for using Vaadin with OSGI containers. The osgi integration part is adapted from the project https://github.com/vaadin/osgi-bridge-and-fragmentedui-demo. Also large part of this documentation is extracted from there.

This demo:
1. shows how to run Vaadin application in OSGi container, with Vaadin artifacts deployed to the container as OSGi bundles and the application itself being OSGi bundle, more specifically Web Application Bundle (WAB)
2. provides a thin, simple example on how to have other bundles in the container contribute to the Vaadin application UI

This is only a proof of concept. In particular the demo doesn't show any best practices as for now, its only purpose is to prove that running mutli-bundle OSGi-Vaadin applications is possible. Also, there are things that are known not to work.

## Setup ##
What you need to run the demo:
0. Use latest Java 1.8 from Oracle
1. Download and install latest Karaf 4.x (at the moment this is 4.0.0.M1)
2. (Optional, but recomended) For convenience, install `webconsole` feature in Karaf:
        # }> cd $KARAF_HOME
        # }> bin/karaf
        karaf }> feature:install webconsole
This will ease deployment of OSGi bundles to Karaf

3. Install `war` feature in Karaf
        karaf }> feature:install war

  This will install, if not yet installed:  
  * Jetty
  * Support for simple HTTP
  * Support for WAR files and Web Application Bundles

4. Compile and deploy osgi bundles that are dependencies for the example bundles
  These bundles can be created as follows: 
  run mvn clean install for the osgi-dependencies project
  go to osgi-bundles/target/ and extract the zip file
  look for the lib folder
  copy the bundles in the lib folder to `$KARAF_HOME\deploy`. Karaf will hot-deploy dropped files

5. Build and deploy demo bundles
  The actual demo consists of four maven projects:  
  * demo-app – this is OSGi bridge and Vaadin WAB application
  * leafletbundle – this is bundle that contributes leaflet map to the example application  
  * mapbundle – this is bundle that contributes openlayers map to the example application  
  * tablebundle – this is bundle that contributes vaadin table with some data to the example application  

  First, you need to build and install demo-app project to your local maven repository, as it is used by the other bundles as a maven dependency:  

        # }> cd $DEMO_ROOT/demo-app
        # }> mvn clean install

  Then, you can build the other projects:

        # }> cd $DEMO_ROOT/leafletbundle
        # }> mvn clean package

        # }> cd $DEMO_ROOT/mapbundle
        # }> mvn clean package

        # }> cd $DEMO_ROOT/tablebundle
        # }> mvn clean package


  Package is enough to get a deployable bundle

  Then deploy all bundles on Karaf (copy to karaf/deploy folder).  
  Finally, you can start the demo. Open the web browser and go to http://localhost:8181/vaadin-osgi. You will see the main application window. The demo bundles are displayed as labels on the top bar. You can drag and drop the labels to the layout slots below. Use the combobox to change the layout structure. 

  You can use the webconsole feature of karaf (http://localhost:8181/system/console/bundles) to start and stop bundles. When you stop a bundle, it is automatically removed from the ui. When you start it, it appears there again. The same functionality can be demonstrated by removing/adding the bundle jar from the karaf/deploy folder. 

## Things known to be broken ##
1. Push. Push won't work because Karaf by default uses Jetty 9.0.7 and Atmosphere support for push used by Vaadin requires at least 9.1.x.
2. Theme compilation. This is caused by sac.jar not being deployable as OSGi bundle (no OSGi metadata in `META-INF/MANIFEST.MF` file)




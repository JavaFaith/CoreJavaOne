package Chapter07.logging;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A modification of the image viewer program that logs various event
 * @version 1.03 2022-05-16
 * @author Robin Wan
 */
public class LoggingImageViewer {
    public static void main(String[] args){
        if(System.getProperty("java.util.logging.config.class") == null
            && System.getProperty("java.util.logging.config.file") == null){
            try{
                Logger.getLogger("com.wan.corejava").setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                Handler handler = new FileHandler("%h/LoggingImageViewer.log",0,LOG_ROTATION_COUNT);
                Logger.getLogger("com.wan.corejava").addHandler(handler);
            }catch(IOException e){
                Logger.getLogger("com.wan.corejava").log(Level.SEVERE,
                        "Can't create log file handler",e);
            }
        }

        EventQueue.invokeLater(() -> {
            Handler windowHandler = new WindowHandler();
        });
    }
}

class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    private static Logger logger = Logger.getLogger("com.wan.corejava");

    public ImageViewerFrame(){
        logger.entering("ImageViewerFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //set up menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu  menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener);


    }

    private class FileOpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            logger.entering("ImageViewerFrame","actionPerformed",event);

            //set up file chooser
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            //accept all files ending with .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter(){
                public boolean accept(File f){
                  return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                public String getDescription(){
                    return "GIF Images";
                }
            });

            //show file choose dialog
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            //if image file accepted,set it as icon of the label
            if(r == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(LEVEL.FINE,"Reading file{0}",name);
                label.setIcon(new ImageIcon(name));
            }
            else logger.fine("File open dialog canceled");
            logger.exiting("ImageViewerFrame.FileOpenlistener","actionPerformed");
        }
    }
}

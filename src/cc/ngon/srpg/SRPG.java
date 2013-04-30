/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.ngon.srpg;

import cc.ngon.Config;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 *
 * @author Ben Cochrane
 */
public class SRPG {

    public SRPG() {
        Config.LoadConfig("res/config.xml");
        fps = Config.getInt("prefs", "fps");
        
        try {
            Display.setDisplayMode(new DisplayMode(Config.getInt("prefs", "scrWidth"), Config.getInt("prefs", "scrHeight")));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(SRPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Resources.loadAllFiles();
        
    }
    
    public void execute() {
        
        Map m = MapBuilder.loadMapFromCSV(new File("res/lev/level0.csv"));
        
        while (!Display.isCloseRequested()) {
            m.update();
            m.render();
            Display.update();
            Display.sync(fps);
        }
        
        Display.destroy();
    }
    
    private int fps;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SRPG rpg = new SRPG();
        rpg.execute();
    }
}

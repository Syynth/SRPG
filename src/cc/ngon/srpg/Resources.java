/**
 * @date Apr 29, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg;

import cc.ngon.srpg.gfx.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.util.vector.Vector3f;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public final class Resources {
    
    public static Texture getTexture(String key) {
        return texs.get(key);
    }
    
    public static Mesh getMesh(String key) {
        return meshes.get(key);
    }

    public static void loadAllFiles() {
        File texDir = new File("res/tex/");
        ArrayList<File> texFiles = new ArrayList<>();
        texFiles.addAll(Arrays.asList(texDir.listFiles()));
        for (File f : texFiles) {
            if (!f.isDirectory() && f.getName().endsWith(".png")) {
                try {
                    texs.put(trimFilename(f.getName()), TextureLoader.getTexture(".png", new FileInputStream(f)));
                } catch (IOException ex) {
                    Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        File modDir = new File("res/mod/");
        ArrayList<File> modFiles = new ArrayList<>();
        modFiles.addAll(Arrays.asList(modDir.listFiles()));
        for (File f : modFiles) {
            if (!f.isDirectory() && f.getName().endsWith(".obj")) {
                try {
                    meshes.put(trimFilename(f.getName()), loadObjFile(f));
                } catch (Exception ex) {
                    Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private static String trimFilename(String name) {
        return name.trim().substring(0, name.length() - 4);
    }
    
    private static Mesh loadObjFile(File f) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        Mesh m = new Mesh();
        
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("v ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);
                //m.verts.add(new Vector3f(x, y, z));
            } else if (line.startsWith("vn ")) {
                float x = Float.valueOf(line.split(" ")[1]);
                float y = Float.valueOf(line.split(" ")[2]);
                float z = Float.valueOf(line.split(" ")[3]);
                m.norms.add(new Vector3f(x, y, z));
            } else if (line.startsWith("f ")) {
                Vector3f vInd = new Vector3f(
                        Float.valueOf(line.split(" ")[1].split("/")[0]),
                        Float.valueOf(line.split(" ")[2].split("/")[0]),
                        Float.valueOf(line.split(" ")[3].split("/")[0]));
                Vector3f nInd = new Vector3f(
                        Float.valueOf(line.split(" ")[1].split("/")[2]),
                        Float.valueOf(line.split(" ")[2].split("/")[2]),
                        Float.valueOf(line.split(" ")[3].split("/")[2]));
                m.faces.add(new Face(vInd, nInd, null));
            }
        }
        reader.close();
        return m;
    }
    
    private Resources() {}
    
    private static HashMap<String, Mesh> meshes = new HashMap<>();
    private static HashMap<String, Texture> texs = new HashMap<>();
    
}

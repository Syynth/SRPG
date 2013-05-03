/**
 * @date Apr 30, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg.gfx;

import cc.ngon.L;
import cc.ngon.srpg.*;
import org.lwjgl.util.vector.Vector3f;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

public class Camera {
    
    public Camera() {
        this(60, 640/480, 0.1f, 1000);
    }

    public Camera(float angle, float aspect, float znear, float zfar) {
        this.angle = angle;
        this.aspect = aspect;
        this.znear = znear;
        this.zfar = zfar;

        position = new Vector3f();
        rotation = new Vector3f();
    }

    public Camera moveTo(Vector3f position) {
        this.position.x = position.x;
        this.position.y = position.y;
        this.position.z = position.z;
        return this;
    }

    public Camera moveBy(Vector3f delta) {
        this.position.x += delta.x;
        this.position.y += delta.y;
        this.position.z += delta.z;
        return this;
    }

    public Camera rotateTo(Vector3f rotation) {
        this.rotation.x = rotation.x;
        this.rotation.y = rotation.y;
        this.rotation.z = rotation.z;
        return this;
    }

    public Camera rotateBy(Vector3f delta) {
        this.rotation.x += delta.x;
        this.rotation.y += delta.y;
        this.rotation.z += delta.z;
        return this;
    }
    
    public Camera initGL() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 640, 480, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        return this;
    }
    
    public Camera renderMap(Map m) {
        glTranslatef(position.x, position.y, 0);
        glClear(GL_COLOR_BUFFER_BIT);
        for (Terrain tr[] : m.field) {
            for (Terrain t : tr) {
                if (t != null) {
                    t.material.t.bind();
                    glBegin(GL_TRIANGLES);
                        for (Face f : t.mesh.faces) {
                            Vector2f v1 = t.mesh.verts.get((int)f.v.x - 1);
                            Vector2f v2 = t.mesh.verts.get((int)f.v.y - 1);
                            Vector2f v3 = t.mesh.verts.get((int)f.v.z - 1);
                            Vector2f t1 = t.mesh.tex.get((int)f.t.x - 1);
                            Vector2f t2 = t.mesh.tex.get((int)f.t.y - 1);
                            Vector2f t3 = t.mesh.tex.get((int)f.t.z - 1);
                            glTexCoord2f(t1.x, t1.y);
                            glVertex2f(v1.x, v1.y);
                            glTexCoord2f(t2.x, t2.y);
                            glVertex2f(v2.x, v2.y);
                            glTexCoord2f(t3.x, t3.y);
                            glVertex2f(v3.x, v3.y);
                        }
                    glEnd();
                } else {
                }
            }
        }
        return this;
    }
    
    public float angle;
    public float aspect;
    public float znear;
    public float zfar;
    public Vector3f position;
    public Vector3f rotation;
    
}

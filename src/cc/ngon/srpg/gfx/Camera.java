/**
 * @date Apr 30, 2013
 * @author Ben Cochrane
 */
package cc.ngon.srpg.gfx;

import cc.ngon.srpg.*;
import org.lwjgl.util.vector.Vector3f;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import org.lwjgl.util.vector.Vector2f;

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
        gluPerspective(angle, aspect, znear, zfar);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);
        return this;
    }
    
    public Camera renderMap(Map m) {
        glLoadIdentity();
        glRotatef(rotation.x, 1, 0, 0);
        glRotatef(rotation.y, 0, 1, 0);
        glRotatef(rotation.z, 0, 0, 1);
        glTranslatef(position.x, position.y, position.z);
        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        for (Terrain tr[] : m.field) {
            for (Terrain t : tr) {
                if (t != null) {
                    glBegin(GL_TRIANGLES);
                        for (Face f : t.mesh.faces) {
                            t.material.t.bind();
                            Vector3f v1 = t.mesh.verts.get((int)f.v.x);
                            Vector3f v2 = t.mesh.verts.get((int)f.v.y);
                            Vector3f v3 = t.mesh.verts.get((int)f.v.z);
                            Vector2f t1 = t.mesh.tex.get((int)f.t.x);
                            Vector2f t2 = t.mesh.tex.get((int)f.t.y);
                            Vector2f t3 = t.mesh.tex.get((int)f.t.z);
                            glTexCoord2f(t1.x, t1.y);
                            glVertex3f(v1.x, v1.y, v1.z);
                            glTexCoord2f(t2.x, t2.y);
                            glVertex3f(v2.x, v2.y, v2.z);
                            glTexCoord2f(t3.x, t3.y);
                            glVertex3f(v3.x, v3.y, v3.z);
                        }
                    glEnd();
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

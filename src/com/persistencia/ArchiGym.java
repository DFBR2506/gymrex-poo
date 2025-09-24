/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.persistencia;

import com.entidades.Gimnasio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jhona
 */
public class ArchiGym {
    public void guardar(Gimnasio gimnasio) throws FileNotFoundException, IOException{
        FileOutputStream file = new FileOutputStream("gimnasio.obj");
        ObjectOutputStream salida = new ObjectOutputStream(file);
        salida.writeObject(gimnasio);
        salida.close();
        file.close();
    }
    public Gimnasio cargar() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("gimnasio.obj");
        ObjectInputStream entrada = new ObjectInputStream(file);
        Gimnasio gym = (Gimnasio) entrada.readObject();
        entrada.close();
        file.close();
        return gym;
    }
}

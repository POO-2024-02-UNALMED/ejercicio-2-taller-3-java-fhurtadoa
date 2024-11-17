
package compras;

import gestionHumana.Empleado; 
import java.util.ArrayList;


public class OrdenCompra { //Nombre del archivo

    public int codigo; //Se necesita accederlo en otra clase de otro paquete
    private String tipo; //No se usa fuera de la clase
    private Empleado comprador; //No se usa fuera de la clase
    private ArrayList<Producto> productos; //No se usa fuera de la clase

    public OrdenCompra(int codigo, String tipo, Empleado comprador,
            ArrayList<Producto> productos) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.comprador = comprador;
        this.productos = productos;
        Producto.totalProductosPedidos += productos.size();
    }

    public void agregarProducto(Producto producto) { //Necesita ser accedido desde otra clase de otro paquete
        if (producto.tipo.equals(tipo)) {
            productos.add(producto);
            Producto.totalProductosPedidos++;
        }
    }

    public void retirarProducto(Empleado empleado, Producto producto) { //Necesita ser accedido desde otra clase de otro paquete
        if (!empleado.tengoPermiso()) {
            return; //Hace que termine el metodo
        }
        retirarProducto(producto);
    }

    private void retirarProducto(Producto producto) { //No se usa fuera de la clase
        for (int i = 0; i < productos.size(); i++) { //Itera a lo largo de la lista
            if (producto.getCodigo() == productos.get(i).getCodigo()) {
                productos.remove(i);
                producto.totalProductosPedidos--;
                producto.imprimirNombre();
                System.out.println(" retirado");
                break;
            }
        }
    }

    public void descontar() { //Retorna null
        Producto.totalProductosPedidos -= productos.size();
    }

}
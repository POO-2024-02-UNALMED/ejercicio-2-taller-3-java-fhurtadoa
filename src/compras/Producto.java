
package compras;

public class Producto {
    
    private final int codigo; //No se usa fuera de la clase
    private String nombre; //No se usa fuera de la clase
    String tipo;  //Necesito ser accedido en otra clase del mismo paquete
    static int totalProductosPedidos; //Atributo de clase

    public Producto(int codigo, String nombre, String tipo) { //Necesito ser accedido en otra clase de otro paquete
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    void imprimirNombre() { //Default para ser conocido en todo el paquete
        System.out.print(nombre);
    }

    public void setCodigo(int codigo) {
        return; //pass
    }

    public int getCodigo() { //Codigo es de tipo entero
        return codigo;
    }

    public static int getTotalProductosPedidos() { //Se necesita accederlo en otra clase de otro paquete
        return totalProductosPedidos;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1.Escribir el codigo que devuelva una cadena al reves
        ejercicio1();
        //2. Crear un array bidimencioanl de enteros y recorrerlo, mostrar la posicion y el valor
        System.out.println();
        ejercicio2();
        //3. Crear Vector del tipo que prefieras y añade 5 elementos, elimina el 2 y 3 y mostrar
        System.out.println();
        ejercicio3();
        //4. el problema de usar un vector con 1000 elementos
        System.out.println();
        ejercicio4();
        //5. crear un arraylist de 4 elementros tipo String y copiarlo a un linkedList y mostrar
        System.out.println();
        ejercicio5();
        //6. crear un ArrayList, rellenarlo de numeros 1..10 eliminar los partes y mostrar
        System.out.println();
        ejercicio6();
        //7. crear un exepcion y mostrar "esto no se puede hacer" y "demo de codigo" en cualquier caso
        System.out.println();
        ejercicio7();
        //8. crear una funcion utilizando InputStream y PrintStream para copiar un fichero en otro
        System.out.println();
        ejercicio8();
        //9. ejercicio sorpresa
        ejercicio9();

    }
    //--------------------------------------------------------1
    public static void ejercicio1(){
        System.out.println("1. Invertir cadena de texto");
        String cadena = "Hola mundo";
        String cadenaInversa = reverse(cadena);
        System.out.println("cadena normal: "+ cadena);
        System.out.println("cadena inversa: "+cadenaInversa);
    }
    public static String reverse(String texto){
        String newCadena="";
        String ollCadena=texto;
        for (int i = ollCadena.length()-1; i >= 0 ; i--) {
            newCadena=newCadena.concat(String.valueOf(ollCadena.charAt(i)));
        }
        return newCadena;
    }
    //--------------------------------------------------------2
    public static void ejercicio2(){
        int[] arrayN = new int[]{1,2,23,4,5,6,7};
        System.out.println("2. Array de enteros");
        for (int i = 0; i < arrayN.length; i++) {
            System.out.println("valor: "+arrayN[i]+" Posicion: "+i);
        }
    }
    //--------------------------------------------------------3
    public static void ejercicio3() {
        System.out.println("3. crear un vector, eliminar datos y mostrarlo");
        ArrayList<String> arrayS = new ArrayList<String>();
        arrayS.add("hola");
        arrayS.add("mundo");
        arrayS.add("como");
        arrayS.add("esta?");
        arrayS.remove(1);
        arrayS.remove(1);
        for(String linea: arrayS){
            System.out.println(linea);
        }
    }
    //--------------------------------------------------------4
    public static void ejercicio4(){
        System.out.println("4. el problema de usar un vector iniciando por la capacidad por defecto " +
                "hasta 1000 elementos\n es que intermanete va creando cadenas de el doble de su tamaño " +
                "a medida que se va llenando\n y copia los elementos a esa nueva cadena llenando la " +
                "memoria de informacion y saturando la computadora");
    }
    //--------------------------------------------------------5
    public static void ejercicio5(){
        System.out.println("5. Crear un ArrayList, copiarlo en un LinkedList y mostrarlos");
        ArrayList<String> arrayS = new ArrayList<String>();
        arrayS.add("Cadena1");
        arrayS.add("Cadena2");
        arrayS.add("Cadena3");
        arrayS.add("Cadena4");
        LinkedList<String> linkedS = new LinkedList<String>(arrayS);
        for (int i=0; i<arrayS.size();i++){
            System.out.println("ArrayList en posicion"+i+": "+arrayS.get(i));
            System.out.println("LinkedList en posicion"+i+": "+linkedS.get(i));

        }
    }
    //--------------------------------------------------------6
    public static void ejercicio6(){
        System.out.println("6. crear un array de numero, eleminar los pares y mostar el array");
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        for (int i=1;i<11;i++){
            numeros.add(i);
        }
        int i =0;
        while (i<numeros.size()){
            if(numeros.get(i)%2==0){
                numeros.remove(i);
            }
            else {
                System.out.println(numeros.get(i));
                i++;
            }
        }
    }
    //--------------------------------------------------------7
    public static void ejercicio7(){
        System.out.println("7. crear un exepcion y mostrar \"esto no se puede hacer\" y \"demo de codigo\" en cualquier caso");
        try {
            DividePorCero();
        }catch (ArithmeticException e){
            System.out.println("Esto no se puede hacer");
        }finally{
            System.out.println("Demo de codigo");
        }
    }
    public static void DividePorCero()throws ArithmeticException{
        throw new ArithmeticException();
    }
    //--------------------------------------------------------8
    public static void ejercicio8(){
        System.out.println("8. crear una funcion utilizando InputStream y PrintStream para copiar un fichero en otro");
        InputStream fileIn=null;
        PrintStream fileOut=null;
        try {
            fileIn = new FileInputStream("ficheroIn.txt");
            fileOut = new PrintStream("ficheroOut.txt");
            copiar(fileIn,fileOut);
        } catch (FileNotFoundException e) {
            System.out.println("archivo no encontrado");
        }

        try {
            if(fileOut!=null)fileOut.close();
            if(fileIn!=null)fileIn.close();
        } catch (IOException e) {
            System.out.println("falla al cerrar el fichero");
        }



    }
    public static void copiar(InputStream fileIn, PrintStream fileOut){
        Scanner sc = new Scanner(fileIn);
        while (sc.hasNext()){
            fileOut.println(sc.nextLine());
        }
    }
    //--------------------------------------------------------9
    /*
        directorio que guarda nombre, apellido y correo electronico
        importandolo en un Hasmap datos para mostrarlo y luego guardarlonuevamente
     */
    public static void ejercicio9(){
        Scanner scan = new Scanner(System.in);

        HashMap<Integer,Persona> datos = new HashMap<>();

        Persona persona =null;
        int id=0;

        InputStream fileIn=null;
        PrintStream fileOut=null;

        StringTokenizer token = null;

        String respuesta="";
        //lee el archivo de fichero.txt
        try {
            fileIn = new FileInputStream("fichero.txt");
        } catch (FileNotFoundException e) {
            System.out.println("archivo no encontrado al leer");
        }

        if(fileIn!=null) {
            Scanner sc = new Scanner(fileIn);
            //si es correcto al habrir el archivo lo separa en token y lo guarda en el HasMap datos
            while (sc.hasNext()) {
                persona = new Persona();
                token = new StringTokenizer(sc.next());
                id=Integer.parseInt(token.nextToken(","));
                persona.nombre=token.nextToken(",");
                persona.apellido=token.nextToken(",");
                persona.email=token.nextToken();
                datos.put(id,persona);

            }
            //cierra el archivo
            try {
                fileIn.close();
            } catch (IOException e) {
                System.out.println("falla al cerrar el fichero al leer");
            }

            //muestra el archivo
            System.out.println("datos");
            System.out.println("nombre\tapellido\temail");
            for(Map.Entry<Integer,Persona> dato : datos.entrySet()) {
                System.out.print(dato.getValue().nombre+"\t");
                System.out.print(dato.getValue().apellido+"\t");
                System.out.println(dato.getValue().email);
            }
            //permite añadir nueva persona
            System.out.println("¿añadir persona? S/N");
            respuesta=scan.next();
            scan.nextLine();
            if("S".equals(respuesta.toUpperCase())){
                persona =new Persona();
                System.out.println("Nombre: ");
                persona.nombre=scan.next();
                System.out.println("Apellido: ");
                persona.apellido=scan.next();
                System.out.println("Emil: ");
                persona.email=scan.next();
                //añade la nueva persona al HasMap
                datos.put(++id,persona);
                System.out.println();
                //muestra el Map
                for(Map.Entry<Integer,Persona> dato : datos.entrySet()) {
                    System.out.print(dato.getValue().nombre+"\t");
                    System.out.print(dato.getValue().apellido+"\t");
                    System.out.println(dato.getValue().email);
                }
            }
            //habre el archivo y guarda los datos
            try {
                fileOut = new PrintStream("fichero.txt");
                for(Integer key: datos.keySet()){
                    fileOut.println(key+","+
                            datos.get(key).nombre+","+
                            datos.get(key).apellido+","+
                            datos.get(key).email
                    );
                }
            } catch (FileNotFoundException e) {
                System.out.println("archivo no encontrado al escribir ");
            }
            if(fileOut!=null)fileOut.close();
        }




    }
}
// clase para almacenar los datos del HasMap
class Persona{
    String nombre;
    String apellido;
    String email;
}
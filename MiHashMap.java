import java.util.ArrayList;

public class MiHashMap
{
    //inicializacin de array
    private String[] name;
    private int[] numbers;
    
    //constructor de array para strings y numeros
    public MiHashMap()
    {
        this.name = new String[2];
        this.numbers = new int[2];
        name[0]=("juan");
        name[1]=("pedro");
        numbers[0]=(1);
        numbers[1]=(2);
    }
    
    /**
     * Asocia el valor especificado con la clave especificada.
     * Si la clave existía, entonces sobreescribe su valor y 
     * devuelve el valor antiguo. Si no existía devuelve -1.
     */
    public int put(String clave, int valor)
    {
        boolean find = false;
        int exist = -1;
        int index = 0;
        //si existe solo cambia el valor
       while(index < name.length) //recorremos el array de claves
       {
           if(name[index] == clave)//sicoincide la clave con un valor de array
           {
               exist=numbers[index];//guardamos el valor del array de numeros
               numbers[index] = valor;
               find=true;
           }
           index++;
       }
       
       //sin no existe lo crea en ultimo lugar
       if(find== false)
       {
           ///nuevos array de tamaño mayor
           String[] newname = new String[name.length + 1];
           int[] newnumbers = new int[numbers.length + 1];
           int pos=0;
           //copia los primeros puestos de los array 
           for(int indi = 0; index < numbers.length; indi++)
           {
               newname[indi] = name[indi];
               newnumbers[indi] = numbers[indi];
           }
           //introduce los nuevos valores al final
           newname[name.length]=clave;
           newnumbers[numbers.length]=valor;
           //copia los nuevos array en los antiguos
           name=newname;
           numbers=newnumbers;
       }
        
        return exist;
    }
}

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
        numbers[0]=(4);
        numbers[1]=(8);
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
    
    /**
     * get(String clave): Devuelve el valor asociado con la clave especificada o -1
     * en caso de que la clave no exista.
     */
    public int get(String clave)
    {
        int exist = -1; // variable para guardar el valor de elemento
        boolean find = false;//boleano para salida del bucle
        int index = 0;//cont de posiciones
        
        //recorremos el array para saber si haycoincidencias
        while(index < name.length && !find)
        {
            if(name[index] == clave)
            exist = numbers[index];
            find=true;
            
        }
        return exist;
    }
    
    /**
     * isEmpty(): devuelve true si el mapa no contiene elementos.
     */
    public boolean isEmpty()
    {
        return (name.length == 0);
    }
    
    /**
     * size(): devuelve el número de elementos del mapa.
     */
    public int size()
    {
        
        return name.length;
    }
    
    /**
     * remove(String clave): elimina del mapa el elemento con la clave dada 
     * y devuelve su valor.
     * Si no hay esa clave en el mapa devuelve -1.
     */
    public int remove(String clave)
    {
        int exist = -1;
        boolean find = false;
        int pos = 0;
        String[] newname = new String[name.length - 1];
        int[] newnumbers = new int[numbers.length - 1];
        while(pos < name.length && !find )
        {
            
            if(name[pos]==clave)
            {
               find = true;
               exist=numbers[pos];
               
               
              int posit=0;
              while( posit < name.length)
              {
                if(posit==pos)//si encontramos la posicion cambiamos el valor 
                {
                   
                }
                else if(posit > pos)//tras modificar el elemnto deseado se desplazan los elementos restantes una posicion
                {
                    newname[posit -1] = name[posit];
                    newnumbers[posit -1]= numbers[posit]; //copia de datos en posiciones 
                }
                else if(posit < pos)//copia de datos en posiciones en orden hasta encontrar el elemento pasado por parametro
                {    
                    newname[posit] = name[posit];
                    newnumbers[posit]= numbers[posit]; 
                }  
                 
                 posit++;
              }
                    
            }
           
            
            pos++;
        }
        
        name=newname;
        numbers=newnumbers;
        return exist;
    }
    
    /**
     * clear(): vacía el mapa.
     */
    public void clear()
    {
       String[] newname = new String[name.length ];
       int[] newnumbers = new int[numbers.length ];
        
       name=newname;
       numbers=newnumbers;
    }
    
    /**
     * containsKey(String clave): Devuelve true si el mapa contiene la clave dada.
     */
    public boolean containsKey(String clave)
    {
        boolean find=false;
        int index=0;
        
        while(index < name.length && !find)
        {
            if(name[index]== clave)
            {
                find = true;
            }
            index++;
        }
        

        return find;
    }
    
    /**
     * containsValue(int valor): Devuelve true si el mapa contiene el valor dado.
     */
    public boolean containsValue(int value)
    {
        boolean find=false;
        int index=0;
        
        while(index < numbers.length && !find)
        {
            if(numbers[index]== value)
            {
                find = true;
            }
            index++;
        }
        

        return find;
    }
    
    
    
}

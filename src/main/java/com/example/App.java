package com.example;

import com.sun.jna.Library;
import com.sun.jna.Native;

import java.io.File;
import java.io.PrintWriter;

import com.sun.jna.*;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("pwd=" + System.getProperty("user.dir"));
        fileSize("gocode/bin/lib-sanitize.dylib");

        // https://medium.com/learning-the-go-programming-language/calling-go-functions-from-other-languages-4c7d8bcc69bf
        Awesome awesome = (Awesome) Native.loadLibrary(
            // "./awesome.so", Awesome.class);
            // "./gocode/bin/lib-sanitize.so", Awesome.class); // linux
            "gocode/bin/lib-sanitize.dylib", Awesome.class); // mac

        System.out.printf(""+ awesome.Add(12, 34));
        // System.out.printf(""+ awesome.Cosine(1.0));
        // long[] nums = new long[]{53,11,5,2,88};
        // Memory arr = new Memory( Native.getNativeSize(Long.TYPE));

        // Awesome.GoSlice.ByValue slice = new Awesome.GoSlice.ByValue();
        // slice.data = arr;
        // slice.len = nums.length;
        // slice.cap = nums.length;
        // awesome.Sort(slice);
        // Awesome.GoString.ByValue str = new Awesome.GoString.ByValue();
        // str.p = "Hello Java!";
        // str.n = str.p.length();
        // System.out.printf(""+ awesome.Log(str));
        
    }

    public static void fileSize(String path){
        File f = new File(path);
        int a= 42;
        char c= '.';
        try {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();  
            }
            PrintWriter pw = new PrintWriter(f);
            pw.write(a);
            pw.write(c);
            pw.close();
            System.out.println("file size:"+f.length());
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    public interface Awesome extends Library {
        public class GoSlice extends Structure {
          public Pointer data;
          public long len;
          public long cap;
        }
      
        public class GoString extends Structure {
          public String p;
          public long n;
        }
        public long Add(long a, long b);
        // public double Cosine(double val);
        // public void Sort(GoSlice.ByValue vals);
        // public long Log(GoString.ByValue str);
        public GoString.ByValue Sanitize(GoString.ByValue str);
      }
}

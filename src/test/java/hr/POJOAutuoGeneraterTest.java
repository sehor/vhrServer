package hr;

import org.junit.Test;

import java.io.IOException;

public class POJOAutuoGeneraterTest {


 @Test
    public void test() throws IOException {

     AutoJOPO autoJOPO=new AutoJOPO("HRSecurityDetails","hr.security.hrSecurityDetails");
     autoJOPO
             .addField("private","Integer","id")
             .addField("private","Integer","hrId")
             .addField("private","Integer","roleId")
/*             .addField("private","boolean","enabled")
             .addField("private","String","phone")
             .addField("private","String","address")
             .addField("private","String","remark")
             .addField("private","String","userface")
             .addField("private","String","name")*/



             //.addField("private","String","email")
             //.addField("private","boolean","enable")
            // .addField("private","boolean","locked")
             .buildFiles();

     //System.out.println(beanString);

 }
}

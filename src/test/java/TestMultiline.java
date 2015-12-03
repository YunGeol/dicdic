import org.adrianwalker.multilinestring.Multiline;
import org.junit.Test;

/**
 * Created by 1001073 on 15. 6. 25..
 */
public class TestMultiline {
    /**
     <html>
     <head>
     <body>
     <p>
     Hello<br/>
     Multiline<br/>
     World<br/>
     saljflsdaij<br/>
     </p>
     </body>
     </head>
     </html>
     */
    @Multiline
    private String html;

    /**
     sdljflsidfj
     asldfjlasdijflias
     sadlifjlasidj
     asldifliasdf
     alsidjlisad
     aa
     */
    @Multiline
    private static String abc;


    @Test
    public void ttt() {
        System.out.println("html : ["+html+"]");
        System.out.println("abc : ["+abc+"]");
    }

}

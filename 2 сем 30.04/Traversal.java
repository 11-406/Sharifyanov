import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Traversal {

    public static void order(Node var) {
        if(var == null) {
            return;
        }
        System.out.println(var.getData());
        order(var.getLeft());
        order(var.getRight());

    }
}

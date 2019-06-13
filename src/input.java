import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class input extends JComponent {
    boolean[] map;
    boolean check=true;
    public input(){
        map=new boolean[256];

        for (int i=0;i<map.length;i++){
            final int key=i;
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,false),2*i);
            getActionMap().put(2 * i, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    map[key]=true;
                }
            });

            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(i,0,true),2*i+1);
            getActionMap().put(2 * i+1, new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    map[key]=false;
                }
            });


        }
    }

    public boolean[] getmap(){
        return Arrays.copyOf(map,map.length);
    }

    public boolean getkey(int w){
        return map[w];
    }


    public boolean pau(boolean per){

        if (check && map[27]){
            check=false;
            per=!per;
            return per;
        }
        if (!map[27]) {check=true; }
        return per;
    }
}

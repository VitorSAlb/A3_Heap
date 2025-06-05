import model.entity.Document;
import model.entity.Priority;
import model.infra.HeapFilaImpressao;

public class FilaImpressao {

    public static void main(String[] args) {
        HeapFilaImpressao fila = new HeapFilaImpressao();

        fila.add(new Document("Doc 1", Priority.NORMAL));
        fila.add(new Document("Doc 2", Priority.URGENT));
        fila.add(new Document("Doc 3", Priority.MEDIUM));

        System.out.println(fila);

        fila.remove();

        System.out.println(fila);
    }
}

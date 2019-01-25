import com.epam.logisticsbase.controller.LogisticBaseController;

public class Main {
    public static void main(String[] args) {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("src/test/resources/Cars.xml","src/main/resources/Cars.xsd",3);
    }
}

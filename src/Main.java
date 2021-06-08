import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileDownloaderProxy fileDownloaderProxy = new FileDownloaderProxy("ex link", new File("ex path"));
        fileDownloaderProxy.download();
    }
}

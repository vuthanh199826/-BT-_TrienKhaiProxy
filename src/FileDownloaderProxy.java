import java.io.File;
import java.io.IOException;

public class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;

    public FileDownloaderProxy(String link, File file) {
        fileDownloader = new FileDownloader(link, file);
    }

    @Override
    public void download() throws IOException {
        fileDownloader.download();
    }
}

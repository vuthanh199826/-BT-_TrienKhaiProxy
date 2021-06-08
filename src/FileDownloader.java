import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownloader implements Downloader{
    private String url;
    private File file;

    public FileDownloader(String url, File file) {
        this.url = url;
        this.file = file;
    }

    @Override
    public void download() throws IOException {
        URL link = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(fileOutputStream,1024);
        byte[] arr = new byte[1024];
        int download = 0;
        int read = 0;
        while ((read = bufferedInputStream.read(arr,0,1024))>=0){
            bufferedOutputStream.write(arr,0,read);
            download +=read;
            System.out.println(download);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
        System.out.println("Complete");
    }
}

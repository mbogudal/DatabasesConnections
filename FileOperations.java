import java.util.List;

public interface FileOperations {
	public void write(String fileName, List<String> scheme, List<String> result);
	public void read();
}

package app;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class TumbTest {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\human\\Desktop\\thumb","origin.jpg");
		Thumbnails
			.of(file)
			.sourceRegion(Positions.CENTER, 200, 200)
			.size(200, 200)
			.toFile(new File("C:\\Users\\human\\Desktop\\thumb","result3.jpg"));
		
	//	String contentType = Files.probeContentType(file.toPath());
	//	System.out.println(contentType);
	//	System.out.println(contentType.startsWith("image"));
	}
}

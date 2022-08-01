package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ThumbTest {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\upload\\2022\\03\\29", "테스트.png");
		Thumbnails
			.of(file)  
			.keepAspectRatio(true)
			.sourceRegion(Positions.CENTER, 200, 200)
//			.size(200, 200)
			.toFile(new File("C:\\Users\\User\\Desktop", "result3.png"));;
		
		String contentType = Files.probeContentType(file.toPath());
		System.out.println(contentType);
		System.out.println(contentType.startsWith("image"));
	}
}

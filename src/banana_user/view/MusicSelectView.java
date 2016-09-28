package banana_user.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_user.domain.Music;

public class MusicSelectView {
	
	private Scanner keyboard;
	
	public MusicSelectView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void musicSelectAll(ArrayList<Music> musicList) {
		
		System.out.println("\n[음원 목록 보기]");
			
		if(musicList.size() == 0) {
			new AlertView().alert("음원이 없습니다.");
		} else {
			System.out.println("음원번호\t노래제목\t가수");	
			for(int i = 0; i < musicList.size(); i++) {
				System.out.print(musicList.get(i).getMusicNumber() + "\t");
				System.out.print(musicList.get(i).getTitle() + "\t");
				System.out.println(musicList.get(i).getSinger());
			}
		}
	}

}
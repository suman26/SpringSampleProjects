package com.abhi.design.adapter;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("Vlc")|| audioType.equalsIgnoreCase("Mp4"))
		{
			mediaAdapter =new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}	
		else if(audioType.equalsIgnoreCase("Mp3"))
            System.out.println("Playing Mp3 file"+fileName);	
		else
			System.out.println("File Fomrat not supported for file:"+fileName);
	}

}

package com.abhi.design.adapter;

public class MediaAdapter implements MediaPlayer{

	  AdvancedMediaPlayer advMediaPlayer;
	  public MediaAdapter(String audioType)
	  {
		  if(audioType.equalsIgnoreCase("Vlc"))
			  advMediaPlayer = new VlcPlayer();
		  if(audioType.equalsIgnoreCase("Mp4"))
			  advMediaPlayer = new Mp4Player();
	  }
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("Vlc"))
			advMediaPlayer.playVlc(fileName);
		if(audioType.equalsIgnoreCase("Mp4"))
			advMediaPlayer.playMp4(fileName);
		
	}

}

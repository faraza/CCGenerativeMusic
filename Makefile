SOUNDFILES=bass1.wav bass2.wav bass3.wav bass4.wav bass5.wav drum1.wav drum2.wav drum3.wav drum4.wav drum5.wav sound1.wav sound2.wav sound3.wav sound4.wav sound5.wav

all: Music

Music: MusicFromKeyPresses.java $(SOUNDFILES)
	javac MusicFromKeyPresses.java

run:
	java MusicFromKeyPresses

clean:
	rm *.class

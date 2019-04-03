@echo off
echo [website-url]: https://www.youtube.com/watch?v=a3HZ8S2H-GQ
echo [youtubedl folder path]: D:\Adam\Logiciels\YoutubeDL\youtube-dl.exe
echo [Format dl]: mp4
echo [destination folder]: D:\Adam
echo [is playlist]: false
cd /D D:\Adam\Logiciels\YoutubeDL\
youtube-dl.exe -o "D:/Adam/%%(title)s.%%(ext)s" https://www.youtube.com/watch?v=a3HZ8S2H-GQ
pause

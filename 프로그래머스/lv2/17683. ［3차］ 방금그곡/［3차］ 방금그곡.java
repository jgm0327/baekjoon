import java.util.Arrays;

class Solution {
    class Music{
        int startH, startM, endH, endM;
        int playTime, idx;
        String name;
        StringBuilder melody;
        
        public Music(int idx, String start, String end, String name, String melody){
            inputTime(start, true);
            inputTime(end, false);
            this.melody = new StringBuilder(melody);
            this.name = name;
            this.idx = idx;
            setPlayTime();
        }
        
        private void inputTime(String time, boolean isStart){
            String[] data = time.split(":");
            int h = Integer.parseInt(data[0]), m = Integer.parseInt(data[1]);
            if(isStart){
                startH = h;
                startM = m;
            }else{
                endH = h;
                endM = m;
                if((h == 0 && m == 0) && (startH != 0)){
                    endH = 24;
                }
            }
        }
        
        private void setPlayTime(){
            if(endM < startM){
                endH--;
                endM += 60;
            }
            playTime += (endM - startM);
            playTime += (endH - startH) * 60;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] key = {"C#", "D#", "F#", "G#", "A#"}, values = {"H", "L", "I", "Y", "U"};
        
        for(int i=0 ; i<key.length ; i++){
            m = m.replaceAll(key[i], values[i]);    
        }
        
        int n = musicinfos.length;
        Music[] musics = new Music[n];
        for(int i=0 ; i<n; i++){
            String[] str = musicinfos[i].split(",");
            for(int j=0 ; j<key.length; j++){
                str[3] = str[3].replaceAll(key[j], values[j]);
            }
            
            musics[i] = new Music(i, str[0], str[1], str[2], str[3]);
        }
        System.out.println(musics[0].playTime);
        
        
        Arrays.sort(musics, (o1, o2) -> {
            if(o2.playTime > o1.playTime) return 1;
            else if(o2.playTime == o1.playTime && o1.idx > o2.idx)return 1;
            return -1;
            });
        
        for(int i=0 ; i<n ; i++){
            StringBuilder melody = musics[i].melody;
            int time = musics[i].playTime;
            if(check(m, melody.toString(),time))return musics[i].name;
        }
        return "(None)";
    }
    
    private boolean check(String target, String original, int time){
        StringBuilder melody = new StringBuilder();
        for(int i=0 ; i < time ; i++){
            melody.append(original.charAt(i%original.length()));
            if(melody.toString().contains(target))return true;
        }
        return false;
    }
}
import java.util.*;

class Solution {
    class Music implements Comparable<Music>{
        int play;
        int idx;
        
        public Music(int play, int idx){
            this.play = play;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Music o){
            if(o.play != this.play)return o.play - this.play;
            return this.idx - o.idx;
        }
    }
    
    class Gerne implements Comparable<Gerne>{
        String name;
        int plays;
        
        public Gerne(String name, int plays){
            this.name = name;
            this.plays = plays;
        }
        
        @Override
        public int compareTo(Gerne o){
            return o.plays - this.plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        Map<String, ArrayList<Music>> musics = new HashMap<>();
        
        for(int i=0 ; i<genres.length ; i++){
            String name = genres[i];
            int play = plays[i];
            
            if(!musics.containsKey(name))
                musics.put(name, new ArrayList<>());
            
            musics.get(name).add(new Music(play, i));
            count.put(name, count.getOrDefault(name, 0) + play);
        }
        
        ArrayList<Gerne> list = new ArrayList<>();
        for(String key : count.keySet()){
            list.add(new Gerne(key, count.get(key)));           
        }
        Collections.sort(list);
        
        for(Gerne genre : list){
            String name = genre.name;
            
            ArrayList<Music> musicList = musics.get(name);
            Collections.sort(musicList);
            for(int i=0 ; i<Math.min(2, musicList.size()) ; i++){
                answer.add(musicList.get(i).idx);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
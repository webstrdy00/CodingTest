import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> countMap = new HashMap<>();  // {음악 장르, 횟수}
        HashMap<String, List<int[]>> songsMap = new HashMap<>(); // {장르, (고유 번호, 재생 횟수)}
        
        for(int i = 0; i < genres.length; ++i){     // 횟수와 곡 목록 업데이트 과정
            String genre = genres[i];
            int play = plays[i];
            
            countMap.put(genre, countMap.getOrDefault(genre, 0) + play);    // 장르별 총 횟수 업데이트
            
            songsMap.putIfAbsent(genre, new ArrayList<>()); // 장르별 곡 목록 업데이트
            songsMap.get(genre).add(new int[]{i, play});
        }
        
        List<String> sortedGenres = new ArrayList<>(countMap.keySet());    
        sortedGenres.sort((a, b) -> countMap.get(b) - countMap.get(a));   // 내림차순 정렬
        
        List<Integer> answer = new ArrayList<>();
        
        for(String genre : sortedGenres){   // 가장 많이 들은 장르 순서대로 진행
            List<int[]> songs = songsMap.get(genre);
            
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]); // 재생 횟수로 내림차순 정렬, 같을시 고유번호가 더 적은 순서대로 정렬
            
            // 최대 2곡 저장 가능
            answer.add(songs.get(0)[0]);
            if(songs.size() > 1){
                answer.add(songs.get(1)[0]);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
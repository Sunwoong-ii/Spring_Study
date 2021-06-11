package com.greedy.section01.advice.xmlconfig;

import org.springframework.stereotype.Component;

@Component("greedyStudent")
public class GreedyStudent implements Student{

	@Override
	public AchievementResult study(Passion passion) throws Exception {
		
		if(passion.getScore() != 10) {
			throw new Exception("GreedyStudent는 열정이 MAX이어야 한다. 열정 부족! 열정 갖고와~~~");
		}
		
		int understandingScore = 0; //이해도
		int satisfactionScore = 0; // 만족도
		double employeementRate = 0.0; //취업율
		
		int passionScore = passion.getScore(); //열정점수
		
		int difficulty = 10; //난이도
		
		for(int i = 1; i <= 4; i++) {
			System.out.println(i + "교시 수업을 열심히 듣습니다. 하지만 너무 어렵습니다.");
			System.out.println("이해도와 만족도가 열정에 비례하여 자꾸 떨어집니다.");
			understandingScore -= difficulty * passionScore;
			satisfactionScore -= difficulty * passionScore;
			
			System.out.println("하지만 신기하게 취업률이 올라가고있다~");
			employeementRate += difficulty * passionScore;
			
			if(i == 3) {
				System.out.println("잠시 밥을 먹으며 오전에 수업들은 내용으로 토론을 합니다. 밥을 코로 먹는건지 입으로 먹는건지 잘 모르겠습니다.");
				
				employeementRate += difficulty * passionScore;
			}
		}
		
		
		return new AchievementResult(understandingScore, satisfactionScore, employeementRate);
	}
	

}

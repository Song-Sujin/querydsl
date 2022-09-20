package study.querydsl.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// JPA는 기본 생성자가 있어야 함. JPA 기본 스펙에서 protected레벨까지 허용 해줌
@ToString(of = {"id", "name"})
public class Team {

    @Id @GeneratedValue
    private Long id;
    private String name;

    // 양방향 연관관계라서 주인을 설정해주어야 함. 이건 거울
    // 연관관계의 주인이 아니라서 외래키 값을 업데이트 하지 않는다.
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}

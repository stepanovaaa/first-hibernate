package hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category", schema = "todolist", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    @Column(name = "completed_count", updatable = false)
    private Long completedCount;
    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id") // по каким полям связывать эти 2 объекта
    private User user;
}

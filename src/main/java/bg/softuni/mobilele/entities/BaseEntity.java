package bg.softuni.mobilele.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column()
  protected Instant created;

  @Column()
  protected Instant modified;

}

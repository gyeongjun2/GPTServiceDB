package chat.db.model;


import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int Accommodation;
    private int Food;
    private int Other;
    private int Shopping;
    private int Transportation;

    //json 데이터 대문자로 받아오기
    @JsonSetter("Accommodation")
    public void setAccommodation(int accommodation) {
        Accommodation = accommodation;
    }

    @JsonSetter("Food")
    public void setFood(int food) {
        Food = food;
    }

    @JsonSetter("Other")
    public void setOther(int other) {
        Other = other;
    }

    @JsonSetter("Shopping")
    public void setShopping(int shopping) {
        Shopping = shopping;
    }

    @JsonSetter("Transportation")
    public void setTransportation(int transportation) {
        Transportation = transportation;
    }
}

package edu.example.studentorder.domain.register;

/*
Класс ответ, возвращает сущетсвует ли человек в ГРН, прописан ли он или нет
 */
public class CityRegisterResponse {
    private boolean existing; //существует ли
    private Boolean temp; //временный

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemp() {
        return temp;
    }

    public void setTemp(Boolean temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "CityRegisterResponse{" +
                "existing=" + existing +
                ", temp=" + temp +
                '}';
    }
}

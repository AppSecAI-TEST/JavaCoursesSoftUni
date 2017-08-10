package softuni.photography.dto.bindingModels.add;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AddPhotographerJsonDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String phone;
    @Expose
    private List<Long> lenses;

    public AddPhotographerJsonDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getLenses() {
        return lenses;
    }

    public void setLenses(List<Long> lenses) {
        this.lenses = lenses;
    }
}

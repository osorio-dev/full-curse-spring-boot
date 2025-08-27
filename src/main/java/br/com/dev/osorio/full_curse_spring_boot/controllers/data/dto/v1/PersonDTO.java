package br.com.dev.osorio.full_curse_spring_boot.controllers.data.dto.v1;

import br.com.dev.osorio.full_curse_spring_boot.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//Annotation para definir a ordem e reorganizar o json retornado ao client
//@JsonPropertyOrder({"id", "first_name", "last_name", "address", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private Long id;

    //Annotation para alterar a exibição da propriedade.
    //@JsonProperty("first_name")
    private String firstName;

    //@JsonProperty("last_name")
    private String lastName;
    private String address;

    //Annotation para formatação de datas
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    //Annotation para Ignorar um campo no json.
    //@JsonIgnore
    //Annotation para customizar serializer
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String firstName, String lastName, String address, Date birthday, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(getId(), personDTO.getId()) && Objects.equals(getFirstName(), personDTO.getFirstName()) && Objects.equals(getLastName(), personDTO.getLastName()) && Objects.equals(getAddress(), personDTO.getAddress()) && Objects.equals(getBirthday(), personDTO.getBirthday()) && Objects.equals(getGender(), personDTO.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getAddress(), getBirthday(), getGender());
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}

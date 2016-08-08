package simple.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sai on 16-8-7.
 */
@RestController
@RequestMapping("/company")
public class CompanyRestController
{

    @RequestMapping("/all")
    List<Company> getCompany()
    {
        String[] names = {"jiba", "dajiba", "xiaojiba"};
        return Arrays
                .stream(names)
                .map(Company::new)
                .collect(Collectors.toList());
    }

}

class Company
{

    String name;
    String location;

    public Company() {
    }

    public Company(String name) {

        this.name = name;
        this.location = "aaaa";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
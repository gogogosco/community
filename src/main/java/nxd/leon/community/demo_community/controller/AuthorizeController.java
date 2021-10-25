package nxd.leon.community.demo_community.controller;

import nxd.leon.community.demo_community.dto.AccessTokenDTO;
import nxd.leon.community.demo_community.dto.GithubUser;
import nxd.leon.community.demo_community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.reditect.url}")
    private String clientUrl;



    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("");
        accessTokenDTO.setClient_secret("");
        accessTokenDTO.setCode("");
        accessTokenDTO.setRedirect_url("");
        accessTokenDTO.setState("");
        String token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(token);

        return "index";
    }
}

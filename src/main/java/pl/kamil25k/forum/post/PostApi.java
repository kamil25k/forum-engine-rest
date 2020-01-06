package pl.kamil25k.forum.post;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

@Api(tags = "posts")
@RequestMapping("/api")
@RestController
public interface PostApi {

    @ApiOperation("Get the comment by the given ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = PostDto.class),
            @ApiResponse(code = 404, message = "Cannot find post")
    })
    @GetMapping(value = "/post/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    Optional<PostDto> getPost(@PathVariable Long id);

    @ApiResponse(code = 200, message = "Posts returned successfully")
    @ApiOperation("Get all posts")
    @GetMapping("/post")
    Collection<PostDto> getPosts();

    @ApiOperation("Delete the post by the given ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Post removed successfully"),
            @ApiResponse(code = 404, message = "Post not found")
    })
    @DeleteMapping(value = "/post/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePost(@PathVariable Long id);

    @ApiOperation("Save the post")
    @PostMapping("/post/user")
    void savePost(@ApiParam(value = "Post object that will be saved", required = true) @Valid
                  @RequestBody PostDto postDto, Principal principal) throws ParseException;

}

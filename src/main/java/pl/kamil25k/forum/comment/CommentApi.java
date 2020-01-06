package pl.kamil25k.forum.comment;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.Collection;
import java.util.Optional;

@Api(tags = "comments")
@RequestMapping("/api")
@RestController
public interface CommentApi {


    @ApiOperation("Get the comment by the given ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = CommentDto.class),
            @ApiResponse(code = 404, message = "Cannot find comment")
    })
    @GetMapping(value = "/comment/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    Optional<CommentDto> getComment(@PathVariable Long id);

    @ApiResponse(code = 200, message = "Comments returned successfully")
    @ApiOperation("Get all comments")
    @GetMapping("/comment")
    Collection<CommentDto> getComments();

    @ApiOperation("Delete the post by the given ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Comment removed successfully"),
            @ApiResponse(code = 404, message = "Comment not found")
    })
    @DeleteMapping(value = "/comment/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteComment(@PathVariable Long id);

    @ApiOperation("Save the comment. Post ID is required")
    @PostMapping("/comment/post/{id}")
    void saveComment(@ApiParam(name = "comment", value = "Comment object that will be saved", required = true)
                     @Valid @RequestBody CommentDto commentDto,
                     @ApiParam(value = "ID of post to comment", required = true, example = "1") @PathVariable Long id, Principal principal) throws ParseException;

}

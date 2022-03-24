# What are Template Engines in general? What is their use?
Template Engines generate　files by combining template and data. Thymeleaf creates html files with the given object.

# What are some features that make the Thymeleaf template interesting?
It can format the data it receives on its own. So there is no need to format it before passing it on. It can also manipulate the number of rows in the table and delete tags, as was done in this assignment. This allows for the generation of various html files from a single template. Front-end developers can work with logics.
   
#Research at least one other common template engine (you can see a list of some here), look at the template’s documentation, then contrast this template with Thymeleaf and discuss differences in philosophy and style, as well as similarities.
Velocity is developed by Apache. The apparent difference is that incity, references are written in the body, whereas in thymeleaf, they are written in tags. Otherwise, it looks the same except for the syntax; Thymeleaf creates html files with tags as the main actors, but this seems to me to be logic first.
Pebble has similar sintax. but it has inheritance feature that let you "extend" parent template. I think this can be useful when using complex conditional branching.
MathJax Basic: Quick Reference
https://medium.com/@sourov.roy/mathjax-basic-quick-reference-eeba0f59b1b7


# physics package 
it contains many math functions, including \tangent and \logarithm
https://docs.mathjax.org/en/latest/input/tex/macros/index.html
it can  only be loaded with tex-svg js!!!! (sic!!!)

## doesn't work
    <script type="text/javascript" id="MathJax-script"
            src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml-full.js">
    </script>
## works
	<script type="text/javascript" id="MathJax-script" async
			src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-svg.js">
	</script>

## mathjax config to be used to load physics package
```javascript
window.MathJax = {
  loader: {load: ['[tex]/physics']},
  tex: {packages: {'[+]': ['physics']}}
};

```

# latex simulator

https://arachnoid.com/latex/

example

```text
26 - 93 + \sqrt{4} + \logarithm{4, 5} + \log_{5} \frac{100}{4} + \cos \frac{\pi}{2}  + 15
```

# discussion on StackExchange for MathMl

https://math.meta.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference



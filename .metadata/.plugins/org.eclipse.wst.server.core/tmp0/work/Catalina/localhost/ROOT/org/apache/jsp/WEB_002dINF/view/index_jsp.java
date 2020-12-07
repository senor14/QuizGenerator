/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.57
 * Generated at: 2020-12-06 14:57:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Oswald:400,700&display=swap\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" />\n");
      out.write("    <link\n");
      out.write("      href=\"https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <link\n");
      out.write("      type=\"text/css\"\n");
      out.write("      href=\"https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\"\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("    />\n");
      out.write("    <title>Document</title>\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/css/style.css\" />\n");
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"/css/style2.css\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <!--\n");
      out.write("    <div class=\"navbar navbar-fixed-top\">\n");
      out.write("      <nav class=\"navbar-inner header\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("          <div class=\"brand\">\n");
      out.write("            IN THE CLOUDS\n");
      out.write("            <i\n");
      out.write("              class=\"fa fa-cloud\"\n");
      out.write("              style=\"text-shadow: 1px 1px white, -1px -1px #666\"\n");
      out.write("            ></i>\n");
      out.write("          </div>\n");
      out.write("          <ul class=\"nav pull-right\">\n");
      out.write("            <li>\n");
      out.write("              <a class=\"nav-link\"> TUTORIALS </a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("              <a class=\"nav-link\"> MODELS </a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("              <a class=\"nav-link\"> PLACES </a>\n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("          <div class=\"triangle-down center\">\n");
      out.write("            <p>\n");
      out.write("              <i id=\"toggle\" class=\"fa fa-chevron-down fa-2x isDown\"></i>\n");
      out.write("            </p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("      <br />\n");
      out.write("    </div>\n");
      out.write("  -->\n");
      out.write("    <!-- div that will hold our WebGL canvas -->\n");
      out.write("    <div id=\"canvas\"></div>\n");
      out.write("\n");
      out.write("    <div id=\"content\">\n");
      out.write("      <div class=\"navbar navbar-fixed-top\">\n");
      out.write("        <nav class=\"navbar-inner header\">\n");
      out.write("          <div class=\"container\">\n");
      out.write("          <a href=\"/index.do\">\n");
      out.write("            <div class=\"brand\" style=\"color : #f89406\">QUIZ GENERATOR</div>\n");
      out.write("            </a>\n");
      out.write("            <ul class=\"nav pull-right\">\n");
      out.write("              <li>\n");
      out.write("                <a class=\"nav-link\"> MYPAGE </a>\n");
      out.write("              </li>\n");
      out.write("              <li>\n");
      out.write("                <a class=\"nav-link\"> BOARD </a>\n");
      out.write("              </li>\n");
      out.write("              <li>\n");
      out.write("                <a class=\"nav-link\"> LOGOUT </a>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"triangle-down center\">\n");
      out.write("              <p>\n");
      out.write("                <i id=\"toggle\" class=\"fa fa-chevron-down fa-2x isDown\"></i>\n");
      out.write("              </p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("        <br />\n");
      out.write("      </div>\n");
      out.write("      <h1 id=\"title\"></h1>\n");
      out.write("\n");
      out.write("      <!-- drag slider -->\n");
      out.write("\n");
      out.write("      <div id=\"planes\">\n");
      out.write("        <div class=\"plane-wrapper\" style=\"width: 500px\">\n");
      out.write("          <span class=\"plane-title\">>.<</span>\n");
      out.write("          <div class=\"plane pasta\">\n");
      out.write("            <img\n");
      out.write("              src=\"/img/pasta1.jpg\"\n");
      out.write("              data-sampler=\"planeTexture\"\n");
      out.write("              alt=\"Photo by Simon Zhu on Unsplash\"\n");
      out.write("              crossorigin\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"plane-wrapper\">\n");
      out.write("          <span class=\"plane-title\" ondblclick=\"location.href='/main/MyPage.do';\">마이 페이지</span>\n");
      out.write("          <div class=\"plane pasta\" ondblclick=\"location.href='/main/MyPage.do';\">\n");
      out.write("            <img\n");
      out.write("              src=\"/img/pasta1.jpg\"\n");
      out.write("              class=\"rainbow\"\n");
      out.write("              data-sampler=\"planeTexture\"\n");
      out.write("              alt=\"Photo by Simon Zhu on Unsplash\"\n");
      out.write("              crossorigin\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"plane-wrapper\">\n");
      out.write("          \n");
      out.write("          <span class=\"plane-title\" ondblclick=\"location.href='/img/img.do';\">문제 만들기</span>\n");
      out.write("          <div class=\"plane pasta\" ondblclick=\"location.href='/img/img.do';\" >\n");
      out.write("            <img\n");
      out.write("              src=\"/img/pasta2.jpg\"\n");
      out.write("              class=\"rainbow\"\n");
      out.write("              data-sampler=\"planeTexture\"\n");
      out.write("              alt=\"Photo by Pedro Lastra on Unsplash\"\n");
      out.write("              crossorigin\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"plane-wrapper\">\n");
      out.write("        \n");
      out.write("          <span class=\"plane-title\" ondblclick=\"location.href='/quiz/quiz.do';\">문제 풀기 - 기본</span>\n");
      out.write("          <div class=\"plane pasta\" ondblclick=\"location.href='/quiz/quiz.do';\">\n");
      out.write("            <img\n");
      out.write("              src=\"/img/pasta3.jpg\"\n");
      out.write("              class=\"rainbow\"\n");
      out.write("              data-sampler=\"planeTexture\"\n");
      out.write("              alt=\"Photo by Denys Nevozhai on Unsplash\"\n");
      out.write("              crossorigin\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"plane-wrapper\">\n");
      out.write("          <span class=\"plane-title\" ondblclick=\"location.href='/main/StudyGame.do';\">문제 풀기 - 게임</span>\n");
      out.write("          <div class=\"plane pasta\" ondblclick=\"location.href='/main/StudyGame.do';\">\n");
      out.write("            <img\n");
      out.write("              src=\"/img/pasta4.jpg\"\n");
      out.write("              class=\"rainbow\"\n");
      out.write("              data-sampler=\"planeTexture\"\n");
      out.write("              alt=\"Photo by Pedro Lastra on Unsplash\"\n");
      out.write("              crossorigin\n");
      out.write("            />\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <div id=\"drag-tip\">Drag to explore</div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script id=\"slider-planes-vs\" type=\"x-shader/x-vertex\">\n");
      out.write("      #ifdef GL_ES\n");
      out.write("      precision mediump float;\n");
      out.write("      #endif\n");
      out.write("\n");
      out.write("      // default mandatory attributes\n");
      out.write("      attribute vec3 aVertexPosition;\n");
      out.write("      attribute vec2 aTextureCoord;\n");
      out.write("\n");
      out.write("      // those projection and model view matrices are generated by the library\n");
      out.write("      // it will position and size our plane based on its HTML element CSS values\n");
      out.write("      uniform mat4 uMVMatrix;\n");
      out.write("      uniform mat4 uPMatrix;\n");
      out.write("\n");
      out.write("      // this is generated by the library based on the sampler name we provided\n");
      out.write("      // it will be used to map adjust our texture coords so the texture will fit the plane\n");
      out.write("      uniform mat4 planeTextureMatrix;\n");
      out.write("\n");
      out.write("      // texture coord varying that will be passed to our fragment shader\n");
      out.write("      varying vec2 vTextureCoord;\n");
      out.write("\n");
      out.write("      void main() {\n");
      out.write("          // apply our vertex position based on the projection and model view matrices\n");
      out.write("          gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);\n");
      out.write("\n");
      out.write("          // varying\n");
      out.write("          // use texture matrix and original texture coords to generate accurate texture coords\n");
      out.write("          vTextureCoord = (planeTextureMatrix * vec4(aTextureCoord, 0.0, 1.0)).xy;\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("    <script id=\"slider-planes-fs\" type=\"x-shader/x-fragment\">\n");
      out.write("      #ifdef GL_ES\n");
      out.write("      precision mediump float;\n");
      out.write("      #endif\n");
      out.write("\n");
      out.write("      // our texture coords varying\n");
      out.write("      varying vec2 vTextureCoord;\n");
      out.write("\n");
      out.write("      // our texture sampler (see how its name matches the data-sampler attribute on our image tags)\n");
      out.write("      uniform sampler2D planeTexture;\n");
      out.write("      // our opacity uniform that goes from 0 to 1\n");
      out.write("      uniform float uOpacity;\n");
      out.write("\n");
      out.write("      void main( void ) {\n");
      out.write("          // map our texture to the varying texture coords\n");
      out.write("          vec4 finalColor = texture2D(planeTexture, vTextureCoord);\n");
      out.write("\n");
      out.write("          // the distance from this point to the top edge is a float from 0 to 1\n");
      out.write("          float distanceToTop = distance(vec2(vTextureCoord.x, 1.0), vTextureCoord);\n");
      out.write("\n");
      out.write("          // calculate an effect that goes from 0 to 1 depenging on uOpacity and distanceToTop\n");
      out.write("          float spreadFromTop = clamp((uOpacity * (1.0 - distanceToTop) - 1.0) + uOpacity * 2.0, 0.0, 1.0);\n");
      out.write("\n");
      out.write("          // handle pre-multiplied alpha on rgb values and use spreadFromTop as alpha.\n");
      out.write("          finalColor = vec4(vec3(finalColor.rgb * spreadFromTop), spreadFromTop);\n");
      out.write("\n");
      out.write("          // this is it\n");
      out.write("          gl_FragColor = finalColor;\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <script id=\"distortion-vs\" type=\"x-shader/x-vertex\">\n");
      out.write("      #ifdef GL_ES\n");
      out.write("      precision mediump float;\n");
      out.write("      #endif\n");
      out.write("\n");
      out.write("      // default mandatory attributes\n");
      out.write("      attribute vec3 aVertexPosition;\n");
      out.write("      attribute vec2 aTextureCoord;\n");
      out.write("\n");
      out.write("      // our displacement texture matrix uniform\n");
      out.write("      uniform mat4 displacementTextureMatrix;\n");
      out.write("\n");
      out.write("      // mouse position and direction uniforms\n");
      out.write("      uniform vec2 uMousePos;\n");
      out.write("      uniform float uDirection;\n");
      out.write("\n");
      out.write("      // custom varyings\n");
      out.write("      varying vec2 vTextureCoord;\n");
      out.write("      varying vec2 vDispTextureCoord;\n");
      out.write("      varying vec2 vMouseTexCoords;\n");
      out.write("\n");
      out.write("      void main() {\n");
      out.write("          gl_Position = vec4(aVertexPosition, 1.0);\n");
      out.write("\n");
      out.write("          // varyings\n");
      out.write("          vTextureCoord = aTextureCoord;\n");
      out.write("          vDispTextureCoord = (displacementTextureMatrix * vec4(aTextureCoord, 0.0, 1.0)).xy;\n");
      out.write("\n");
      out.write("          // we will handle our mouse coords here for better performance\n");
      out.write("          // get our texture coords for both directions\n");
      out.write("          vec2 mouseHorizontalTexCoords = (uMousePos + 1.0) / 2.0;\n");
      out.write("          mouseHorizontalTexCoords.y = 0.5;\n");
      out.write("\n");
      out.write("          vec2 mouseVerticalTexCoords = (uMousePos + 1.0) / 2.0;\n");
      out.write("          mouseVerticalTexCoords.x = 0.5;\n");
      out.write("\n");
      out.write("          // use the right value for the right direction\n");
      out.write("          vMouseTexCoords = mix(mouseHorizontalTexCoords, mouseVerticalTexCoords, uDirection);\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("    <script id=\"distortion-fs\" type=\"x-shader/x-fragment\">\n");
      out.write("      #ifdef GL_ES\n");
      out.write("      precision mediump float;\n");
      out.write("      #endif\n");
      out.write("\n");
      out.write("      // varyings\n");
      out.write("      varying vec2 vTextureCoord;\n");
      out.write("      varying vec2 vDispTextureCoord;\n");
      out.write("      varying vec2 vMouseTexCoords;\n");
      out.write("\n");
      out.write("      // our render texture is basically what's being drawn in our canvas\n");
      out.write("      uniform sampler2D renderTexture;\n");
      out.write("      // the displacement texture we've loaded into our shader pass\n");
      out.write("      uniform sampler2D displacementTexture;\n");
      out.write("\n");
      out.write("      // all our uniforms\n");
      out.write("      uniform float uDragEffect;\n");
      out.write("      uniform vec2 uMousePos;\n");
      out.write("      uniform vec2 uOffset;\n");
      out.write("      uniform float uDirection;\n");
      out.write("      uniform vec3 uBgColor;\n");
      out.write("\n");
      out.write("      void main( void ) {\n");
      out.write("          vec2 textureCoords = vTextureCoord;\n");
      out.write("\n");
      out.write("          // repeat and offset our displacement map texture coords for both slider directions\n");
      out.write("          vec2 horizontalPhase = fract(vec2(vDispTextureCoord.x + uOffset.x, vDispTextureCoord.y + (uOffset.y / 3600.0)) / vec2(1.0, 1.0));\n");
      out.write("          vec2 verticalPhase = fract(vec2(vDispTextureCoord.x * (uOffset.x / 3600.0), vDispTextureCoord.y + uOffset.y) / vec2(1.0, 1.0));\n");
      out.write("\n");
      out.write("          // use the correct repeated and offseted texture coords\n");
      out.write("          vec2 phase = mix(horizontalPhase, verticalPhase, uDirection);\n");
      out.write("          vec4 displacement = texture2D(displacementTexture, phase);\n");
      out.write("\n");
      out.write("          // use our varying mouse texture coords\n");
      out.write("          vec2 mouseTexCoords = vMouseTexCoords;\n");
      out.write("\n");
      out.write("          float distanceToMouse = distance(mouseTexCoords, textureCoords);\n");
      out.write("\n");
      out.write("          // calculate an effect that goes from 0 to 1 depenging on uDragEffect and distanceToMouse\n");
      out.write("          float spreadFromMouse = clamp((uDragEffect * (1.0 - distanceToMouse) - 1.0) + uDragEffect * 2.0, 0.0, 1.0);\n");
      out.write("\n");
      out.write("          // calculate our fish eye like distortions\n");
      out.write("          vec2 fishEye = (vec2(textureCoords - mouseTexCoords).xy) * pow(distanceToMouse, 3.0);\n");
      out.write("\n");
      out.write("          // add a displacement based on our map and our time uniform\n");
      out.write("          float displacementEffect = displacement.r * 1.25;\n");
      out.write("\n");
      out.write("          // spread our fish eye and displacement effects from our mouse\n");
      out.write("          // calculate for both directions\n");
      out.write("          vec2 horizontalTexCoords = textureCoords;\n");
      out.write("          horizontalTexCoords.x -= spreadFromMouse * fishEye.x * displacementEffect / 2.0;\n");
      out.write("          horizontalTexCoords.y += spreadFromMouse * fishEye.y * displacementEffect * 3.0;\n");
      out.write("\n");
      out.write("          vec2 verticalTexCoords = textureCoords;\n");
      out.write("          verticalTexCoords.x += spreadFromMouse * fishEye.x * displacementEffect * 3.0;\n");
      out.write("          verticalTexCoords.y -= spreadFromMouse * fishEye.y * displacementEffect / 2.0;\n");
      out.write("\n");
      out.write("          // use the right value for the right direction\n");
      out.write("          textureCoords = mix(horizontalTexCoords, verticalTexCoords, uDirection);\n");
      out.write("\n");
      out.write("\n");
      out.write("          // get our final colored and BW vec4\n");
      out.write("          vec4 finalColor = texture2D(renderTexture, textureCoords);\n");
      out.write("          float grey = dot(finalColor.rgb, vec3(0.299, 0.587, 0.114));\n");
      out.write("          vec4 finalGrey = vec4(vec3(grey), 1.0);\n");
      out.write("\n");
      out.write("          // mix our both vec4 based on our spread value\n");
      out.write("          finalColor = mix(finalColor, finalGrey, spreadFromMouse * finalColor.a);\n");
      out.write("\n");
      out.write("          float spreadFromMouseAdjusted = spreadFromMouse / sqrt(2.0);\n");
      out.write("\n");
      out.write("          // apply a grey background where we don't have nothing to draw\n");
      out.write("          finalColor = mix(vec4(uBgColor.r * spreadFromMouseAdjusted / 255.0, uBgColor.g * spreadFromMouseAdjusted / 255.0, uBgColor.b * spreadFromMouseAdjusted / 255.0, spreadFromMouseAdjusted), finalColor, finalColor.a);\n");
      out.write("\n");
      out.write("          gl_FragColor = finalColor;\n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("    <script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\n");
      out.write("\n");
      out.write("    <script\n");
      out.write("      src=\"https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js\"\n");
      out.write("      type=\"text/javascript\"\n");
      out.write("    ></script>\n");
      out.write("    <script\n");
      out.write("      src=\"https://www.curtainsjs.com/build/curtains.min.js\"\n");
      out.write("      type=\"text/javascript\"\n");
      out.write("    ></script>\n");
      out.write("    <script src=\"/js/script.js\" type=\"text/javascript\"></script>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package com.mymoney.finance_control.services;

import com.mymoney.finance_control.models.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public void sendWelcomeMail(User user) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = sender;
        String senderName = "Finance App";
        String subject = "Welcome to you future money life";

        String content = """
                <!doctype html>
                <html ⚡4email data-css-strict>
                
                <head>
                  <meta charset="utf-8">
                  <meta name="x-apple-disable-message-reformatting">
                  <style amp4email-boilerplate>
                    body {
                      visibility: hidden
                    }
                  </style>
                
                  <script async src="https://cdn.ampproject.org/v0.js"></script>
                
                
                  <style amp-custom>
                    @media only screen and (min-width: 620px) {
                      .u-row {
                        width: 600px;
                      }
                      .u-row .u-col {
                        vertical-align: top;
                      }
                      .u-row .u-col-100 {
                        width: 600px;
                      }
                    }
                   \s
                    @media only screen and (max-width: 620px) {
                      .u-row {
                        width: 100%;
                      }
                      .u-row .u-col {
                        display: block;
                        width: 100%;
                        min-width: 320px;
                        max-width: 100%;
                      }
                      .u-row .u-col>div {
                        margin: 0 auto;
                      }
                    }
                   \s
                    body {
                      margin: 0;
                      padding: 0;
                    }
                   \s
                    table,
                    tr,
                    td {
                      vertical-align: top;
                      border-collapse: collapse;
                    }
                   \s
                    p {
                      margin: 0;
                    }
                   \s
                    .ie-container table,
                    .mso-container table {
                      table-layout: fixed;
                    }
                   \s
                    * {
                      line-height: inherit;
                    }
                   \s
                    table,
                    td {
                      color: #000000;
                    }
                   \s
                    #u_body a {
                      color: #0000ee;
                      text-decoration: underline;
                    }
                  </style>
                
                
                </head>
                
                <body class="clean-body u_body" style="margin: 0;padding: 0;background-color: #f9f9f9;color: #000000">
                  <!--[if IE]><div class="ie-container"><![endif]-->
                  <!--[if mso]><div class="mso-container"><![endif]-->
                  <table id="u_body" style="border-collapse: collapse;table-layout: fixed;border-spacing: 0;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9f9;width:100%" cellpadding="0" cellspacing="0">
                    <tbody>
                      <tr style="vertical-align: top">
                        <td style="word-break: break-word;border-collapse: collapse;vertical-align: top">
                          <!--[if (mso)|(IE)]><table width="100%" cellpadding="0" cellspacing="0" border="0"><tr><td align="center" style="background-color: #f9f9f9;"><![endif]-->
                
                          <div style="padding: 0px;">
                            <div style="max-width: 600px;margin: 0 auto;">
                              <div class="u-row">
                
                                <div class="u-col u-col-100" style="display:flex;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;">
                                  <div style="width: 100%;padding:0px;">
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; color: #afb0c7; line-height: 170%; text-align: center; word-wrap: break-word;">
                                              <p style="font-size: 14px; line-height: 170%;"><span style="font-size: 14px; line-height: 23.8px;">View Email in Browser</span></p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                  </div>
                                </div>
                
                              </div>
                            </div>
                          </div>
                
                          <div style="padding: 0px;">
                            <div style="max-width: 600px;margin: 0 auto;background-color: #03035c;">
                              <div class="u-row">
                
                                <div class="u-col u-col-100" style="display:flex;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;">
                                  <div style="width: 100%;padding:0px;">
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <table width="100%" cellpadding="0" cellspacing="0" border="0">
                                              <tr>
                                                <td style="padding-right: 0px;padding-left: 0px;" align="center">
                
                                                  <amp-img alt="Image" src="https://cdn.templates.unlayer.com/assets/1597218650916-xxxxc.png" width="335" height="93" layout="intrinsic" style="width: 26%;max-width: 26%;">
                                                  </amp-img>
                
                                                </td>
                                              </tr>
                                            </table>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;">
                                              <p style="font-size: 14px; line-height: 140%;"><strong>T H A N K S&nbsp; &nbsp;F O R&nbsp; &nbsp;S I G N I N G&nbsp; &nbsp;U P !</strong></p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:0px 10px 31px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; color: #e5eaf5; line-height: 140%; text-align: center; word-wrap: break-word;">
                                              <p style="font-size: 14px; line-height: 140%;"><span style="font-size: 28px; line-height: 39.2px;"><strong><span style="line-height: 39.2px; font-size: 28px;">Save Your Money </span></strong>
                                                </span>
                                              </p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                  </div>
                                </div>
                
                              </div>
                            </div>
                          </div>
                
                          <div style="padding: 0px;">
                            <div style="max-width: 600px;margin: 0 auto;background-color: #ffffff;">
                              <div class="u-row">
                
                                <div class="u-col u-col-100" style="display:flex;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;">
                                  <div style="width: 100%;padding:0px;">
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:33px 55px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;">
                                              <p style="line-height: 160%;"><span style="font-size: 22px; line-height: 35.2px;">Olá, ficamos felizes de vermos que está querendo ter mais controle do seu dinheiro, saber para onde ele vai e quanto gasta.</span></p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <!--[if mso]><style>.v-button {background: transparent;}</style><![endif]-->
                                            <div align="center">
                                              <!--[if mso]><v:roundrect xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w="urn:schemas-microsoft-com:office:word" href="https://github.com/Frasato" style="height:46px; v-text-anchor:middle; width:223px;" arcsize="8.5%"  stroke="f" fillcolor="#ff6600"><w:anchorlock/><center style="color:#FFFFFF;"><![endif]-->
                                              <a href="https://github.com/Frasato" target="_blank" class="v-button" style="box-sizing: border-box;display: inline-block;text-decoration: none;text-align: center;color: #FFFFFF; background-color: #ff6600; border-radius: 4px;  width:auto; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; font-size: 14px;">
                                                <span style="display:block;padding:14px 44px 13px;line-height:120%;"><span style="font-size: 16px; line-height: 19.2px;"><strong><span style="line-height: 19.2px; font-size: 16px;">SEE OUR WEBSITE</span></strong>
                                                </span>
                                                </span>
                                              </a>
                                              <!--[if mso]></center></v:roundrect><![endif]-->
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:33px 55px 60px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; line-height: 160%; text-align: center; word-wrap: break-word;">
                                              <p style="line-height: 160%; font-size: 14px;"><span style="font-size: 18px; line-height: 28.8px;">Thanks,</span></p>
                                              <p style="line-height: 160%;"><span style="font-size: 18px; line-height: 28.8px;">Finance App</span></p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                  </div>
                                </div>
                
                              </div>
                            </div>
                          </div>
                
                          <div style="padding: 0px;">
                            <div style="max-width: 600px;margin: 0 auto;background-color: #03035c;">
                              <div class="u-row">
                
                                <div class="u-col u-col-100" style="display:flex;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;">
                                  <div style="width: 100%;padding:0px;">
                
                                    <table style="font-family:'Cabin',sans-serif;" role="presentation" cellpadding="0" cellspacing="0" width="100%" border="0">
                                      <tbody>
                                        <tr>
                                          <td style="overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Cabin',sans-serif;" align="left">
                
                                            <div style="font-size: 14px; color: #fafafa; line-height: 180%; text-align: center; word-wrap: break-word;">
                                              <p style="font-size: 14px; line-height: 180%;"><span style="font-size: 16px; line-height: 28.8px;">Copyrights © Company All Rights Reserved</span></p>
                                            </div>
                
                                          </td>
                                        </tr>
                                      </tbody>
                                    </table>
                
                                  </div>
                                </div>
                
                              </div>
                            </div>
                          </div>
                
                          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->
                        </td>
                      </tr>
                    </tbody>
                  </table>
                  <!--[if mso]></div><![endif]-->
                  <!--[if IE]></div><![endif]-->
                </body>
                
                </html>
                """;

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message);

        messageHelper.setFrom(fromAddress, senderName);
        messageHelper.setTo(toAddress);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        javaMailSender.send(message);
    }

}

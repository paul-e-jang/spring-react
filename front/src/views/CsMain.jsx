import { Card } from '@blueprintjs/core'
import React from 'react'
import '../css/content.scss'

class CsMain extends React.Component {
    constructor(props) {
      super()
      this.state = {
      }
    }

    render() {
    
        return (
            <section id="cs">
                <div className="cs-wrapper">
                    <div className="cs-header"><h2 className="bp3-heading">Hello. What can we help you with?</h2></div>
                    <div className="cs-content-wrapper">
                    <h3 className="bp3-heading">Some things you can do here</h3>
                        <div className="cs-content">
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/1.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">Your Orders</h4><br />Track Packages <br/> Edit or cancel orders</div>
                            </Card>
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/2.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">Return & Refund</h4><br />환불 & 반송 서비스를 <br/> 이용하실 수 있습니다.</div>
                            </Card>
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/3.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">Device Support</h4><br />기기제품 A/S <br/> 받으실 수 있습니다.</div>
                            </Card>
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/5.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">Payment</h4><br />신용카드/결제 정보를 <br/> 등록하세요.</div>
                            </Card>
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/6.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">Your Account</h4><br />계정 정보 수정</div>
                            </Card>
                            <Card interactive>
                            <img className="cs-card-image" src={require('../assets/cs/7.png')} alt="cs-menu" />
                            <div className="cs-card-content"><h4 className="bp3-heading">About COVID-19</h4><br /> 코로나 19 관련<br />공지사항</div>
                            </Card>
                        </div>
                    </div>
                </div>
            </section>
        )
    }
}

export default CsMain
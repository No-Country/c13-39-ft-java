import React from 'react'
import Card from './Card'

function Cards () { 
 
  // const [destinos, setdestinos] = useState([])

  // useEffect(() => { 
    
  //   .then((data) => setdestinos(data.results))
  //   .catch((error) => console.log(error))

  // }, []) 

  const destinos = [
    "Aruba",
    "Mexico",
    "Uruguay"

]
   
  const cardList = destinos.map( (p)=> <Card destino={p} key={p.id} />)

  return (
    <div className="album py-5 bg-light">
    <div className="container">
      <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
          {cardList}
      </div>
    </div>
  </div>
  )
}

export default Cards

const person = {
    name: 'Bibhu Samal',
    address: {
        city: 'Bangalore',
        pincode: '560037'
    },
    profiles: ['twitter', 'facebook', 'instagram'],
    printProfiles: () => {
       person.profiles.map(
           profile => console.log(profile)
       )
    }
}

export default function LearningJavaScript() {
    return (
        <>
            <div>Learning Java Script</div>
            <div>{person.name}</div>
            <div>{person.address.city}</div>
            <div>{person.address.pincode}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.profiles[1]}</div>
            <div>{person.profiles[2]}</div>
            <div>{person.printProfiles()}</div>
        </>
    )
}